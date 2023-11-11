package ifnmg.edu.br.book;

import ifnmg.edu.br.entity.Entity;

import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDate;

public class Book extends Entity{
    private String title;
    private String authors;
    private LocalDate acquisition;
    private Short pages;
    private Short year;
    private Byte edition;
    private BigDecimal price;

    public Book() {
    }

    public Book(Long id, String title, String authors, LocalDate acquisition, Short pages, Short year, Byte edition, BigDecimal price) throws Exception{
        setId(id);

        setTitle(title);
        setAuthors(authors);
        setAcquisition(acquisition);
        setPages(pages);
        setYear(year);
        setEdition(edition);
        setPrice(price);
    }

    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) throws IllegalAccessException{
        if(title.length()<=150) this.title = title;
        else throw new IllegalAccessException("Tamanho invalido!");
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) throws IllegalAccessException{
        if(authors.length()<=250) this.authors = authors;
        else throw new IllegalAccessException("Tamanho invalido!");
    }

    public LocalDate getAcquisition() {
        return acquisition;
    }

    public void setAcquisition(LocalDate acquisition) {
        if(acquisition.isBefore(LocalDate.now())) this.acquisition = acquisition;
        else throw new DateTimeException("Data invalida!");
    }

    public Short getPages() {
        return pages;
    }

    public void setPages(Short pages) throws IllegalAccessException{
        if(pages>=1) this.pages = pages;
        else throw new IllegalAccessException("Quantidade invalida!");
    }

    public Short getYear() {
        return year;
    }

    public void setYear(Short year) throws IllegalAccessException{
        if(year != null) this.year = year;
        else throw new IllegalAccessException("Valor nulo!");
    }

    public Byte getEdition() {
        return edition;
    }

    public void setEdition(Byte edition) throws IllegalAccessException{
        if(edition >= 1) this.edition = edition;
        else throw new IllegalAccessException("Quantidade invalida!");
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) throws IllegalAccessException{
        if(price.compareTo(BigDecimal.ZERO) > 0) this.price = price;
        else throw new IllegalAccessException("Valor invalido!");
    }

    @Override
    public String toString() {
        return "ENCONTRADO {" + "title=" + title + ", authors=" + authors + ", acquisition=" + acquisition + ", pages=" + pages + ", year=" + year + ", edition=" + edition + ", price=" + price + '}';
    }
    
    
}
