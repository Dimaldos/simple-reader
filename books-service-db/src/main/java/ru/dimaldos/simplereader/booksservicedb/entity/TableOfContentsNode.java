package ru.dimaldos.simplereader.booksservicedb.entity;

import java.io.Serializable;

public record TableOfContentsNode(
        Long contentId,
        String title,
        Iterable<TableOfContentsNode> childContents
) implements Serializable {
}
