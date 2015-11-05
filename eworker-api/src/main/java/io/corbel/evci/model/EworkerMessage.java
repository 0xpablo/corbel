package io.corbel.evci.model;

/**
 * @author Alberto J. Rubio
 */
public class EworkerMessage<E> {

    private final Header header;
    private final E content;

    public EworkerMessage(Header header, E content) {
        this.header = header;
        this.content = content;
    }

    public Header getHeader() {
        return header;
    }

    public E getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EworkerMessage<?> that = (EworkerMessage<?>) o;

        if (header != null ? !header.equals(that.header) : that.header != null) return false;
        return !(content != null ? !content.equals(that.content) : that.content != null);

    }

    @Override
    public int hashCode() {
        int result = header != null ? header.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }
}
