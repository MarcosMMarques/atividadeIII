package ifnmg.edu.br;

import ifnmg.edu.br.book.Book;
import ifnmg.edu.br.book.BookDao;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {
 
        try {
            double valor = 7.10;
            BigDecimal valorBig = new BigDecimal(valor);
            
            Book livro = new Book(null, "teste", "Ana Zaira", LocalDate.of(2023, Month.DECEMBER, 12), (short) 2, (short) 1093, (byte) 20, valorBig);
            Long autor1ID = new BookDao().saveOrUpdate(livro);
            livro.setId(autor1ID);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        
        try {
            double valor = 10.20;
            BigDecimal valorBig = new BigDecimal(valor);
            
            Book livro = new Book(null, "teste", "Ana Zaira", LocalDate.of(2023, Month.JUNE, 20), (short) 2, (short) 1093, (byte) 20, valorBig);
            Long autor1ID = new BookDao().saveOrUpdate(livro);
            livro.setId(autor1ID);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            double valor = 90000.50;
            BigDecimal valorBig = new BigDecimal(valor);
            
            Book livro = new Book(null, "teste", "Joao Pedro", LocalDate.of(2023, Month.JANUARY, 15), (short) 2, (short) 1093, (byte) 20, valorBig);
            Long autor2ID = new BookDao().saveOrUpdate(livro);
            livro.setId(autor2ID);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            double valor = 4.50;
            BigDecimal valorBig = new BigDecimal(valor);
            
            Book livro = new Book(null, "teste", "Maria Clara", LocalDate.of(2023, Month.JUNE, 12), (short) 2, (short) 1093, (byte) 20, valorBig);
            Long autor3ID = new BookDao().saveOrUpdate(livro);
            livro.setId(autor3ID);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            double valor = 4.50;
            BigDecimal valorBig = new BigDecimal(valor);
            
            Book livro = new Book(3L, "Troca", "Clara Maria", LocalDate.of(2023, Month.APRIL, 23), (short) 2, (short) 1093, (byte) 20, valorBig);
            Long autor3ID = new BookDao().saveOrUpdate(livro);
            livro.setId(autor3ID);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        try {
            Long idBusca = 1L;
            BookDao buscaid = new BookDao();
            System.out.println(buscaid.findById(idBusca));
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        try {
            Long idBusca = 2L;
            BookDao buscaid = new BookDao();
            System.out.println(buscaid.findById(idBusca));
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        try {
            BookDao buscaALL = new BookDao();
            for(Book e: buscaALL.findAll()){
                System.out.println(e);
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        try {
            BookDao bookdao = new BookDao();
            bookdao.delete(1L);

            System.out.println("");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
