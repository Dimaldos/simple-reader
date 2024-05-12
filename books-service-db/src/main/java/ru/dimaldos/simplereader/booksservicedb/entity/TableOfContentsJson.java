package ru.dimaldos.simplereader.booksservicedb.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.type.SqlTypes;
import org.hibernate.usertype.UserType;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class TableOfContentsJson implements UserType<TableOfContentsNode> {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public int getSqlType() {
        return SqlTypes.JSON;
    }

    @Override
    public Class<TableOfContentsNode> returnedClass() {
        return TableOfContentsNode.class;
    }

    @Override
    public boolean equals(TableOfContentsNode tableOfContentsNode, TableOfContentsNode j1) {
        return false;
    }

    @Override
    public int hashCode(TableOfContentsNode tableOfContentsNode) {
        return 0;
    }

    @Override
    public TableOfContentsNode nullSafeGet(ResultSet rs, int position, SharedSessionContractImplementor session, Object owner)
            throws SQLException {
        final String cellContent = rs.getString(position);
        if (cellContent == null) {
            return null;
        }
        try {
            return mapper.readValue(cellContent.getBytes(StandardCharsets.UTF_8), returnedClass());
        } catch (final Exception ex) {
            throw new RuntimeException("Failed to convert String to MyJson: " + ex.getMessage(), ex);
        }
    }

    @Override
    public void nullSafeSet(PreparedStatement st, TableOfContentsNode value, int index, SharedSessionContractImplementor session)
            throws SQLException {
        if (value == null) {
            st.setNull(index, Types.OTHER);
            return;
        }
        try {
            final StringWriter w = new StringWriter();
            mapper.writeValue(w, value);
            w.flush();
            st.setObject(index, w.toString(), Types.OTHER);
        } catch (final Exception ex) {
            throw new RuntimeException("Failed to convert MyJson to String: " + ex.getMessage(), ex);
        }
    }

    @Override
    public TableOfContentsNode deepCopy(TableOfContentsNode value) {
        try {
            // use serialization to create a deep copy
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(value);
            oos.flush();
            oos.close();
            bos.close();

            ByteArrayInputStream bais = new ByteArrayInputStream(bos.toByteArray());
            TableOfContentsNode obj = (TableOfContentsNode) new ObjectInputStream(bais).readObject();
            bais.close();
            return obj;
        } catch (ClassNotFoundException | IOException ex) {
            throw new HibernateException(ex);
        }
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(TableOfContentsNode value) {
        return null;
    }

    @Override
    public TableOfContentsNode assemble(Serializable cached, Object owner) {
        return null;
    }


}
