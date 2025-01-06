package com.shyloostyle.Rest_Consumer.model;

import java.util.Objects;

public class Quote {
    private Integer id;
    private String quote;
    private String author;

    public Quote(Integer id, String quote, String author) {
        this.id = id;
        this.quote = quote;
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Quote quote1 = (Quote) o;
        return Objects.equals(id, quote1.id) && Objects.equals(quote, quote1.quote) && Objects.equals(author, quote1.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quote, author);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "id=" + id +
                ", quote='" + quote + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
