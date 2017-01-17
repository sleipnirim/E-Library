package by.zhukovski.elibrary.bean;

import java.io.Serializable;

/**
 * Created by sleipnir on 17.1.17.
 */
public class Book implements Serializable{

    private String title;
    private String author;
    private int year;
    private String description;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o){
        if (o == null) return false;
        if (this == o) return true;
        if (this.getClass() == o.getClass()){
            Book b = (Book) o;
            if (this.author == b.author && this.content == b.content && this.description == b.description &&
                    this.title == b.title && this.year == b.year) return true;
        }

        return false;
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 0;
        result = result + title.hashCode()*prime;
        result = result + author.hashCode()*prime;
        result = result + year*prime;
        result = result + description.hashCode()*prime;
        result = result + content.hashCode()*prime;

        return result;
    }

    @Override
    public String toString(){
        return this.title + this.author + this.year + this.description + this.content;
    }


}
