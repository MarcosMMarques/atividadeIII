package ifnmg.edu.br.repository;

import ifnmg.edu.br.entity.Entity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public abstract class Dao<E> implements IDao<E> {
    
    public static final String DB = "library";
    

    @Override
    public Long saveOrUpdate(E e) {

        Long id = 0L;

        if (((Entity) e).getId() == null || ((Entity) e).getId() == 0) {

            
            try ( PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement( getSaveStatement(),Statement.RETURN_GENERATED_KEYS)) {

                composeSaveOrUpdateStatement(preparedStatement, e);

                System.out.println(">> SQL: " + preparedStatement);

                preparedStatement.executeUpdate();

                ResultSet resultSet = preparedStatement.getGeneratedKeys();

                if (resultSet.next()) {

                    
                    id = resultSet.getLong(1);
                }

            } catch (Exception ex) {
                System.out.println(">> " + ex);
            }

        } else {
            try ( PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(
                            getUpdateStatement())) {

                composeSaveOrUpdateStatement(preparedStatement, e);

                System.out.println(">> SQL: " + preparedStatement);

                preparedStatement.executeUpdate();

                id = ((Entity) e).getId();

            } catch (Exception ex) {
                System.out.println("Exception: " + ex);
            }
        }
        return id;
    } 
    
    
    @Override
    public E findById(Long id) {
        try ( PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement( getFindByIdStatement())) {

            
            preparedStatement.setLong(1, id);

            
            System.out.println(">> SQL: " + preparedStatement);

            
            ResultSet resultSet = preparedStatement.executeQuery();

            
            if (resultSet.next()) {
                return extractObject(resultSet);
            }

        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }

        return null;
    } 
    

    @Override
    public List<E> findAll() {
        try ( PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(getFindAllStatement())) {

            
            System.out.println(">> SQL: " + preparedStatement);

            
            ResultSet resultSet = preparedStatement.executeQuery();

            
            return extractObjects(resultSet);

        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }

        return null; 
    }
    
    @Override
    public void delete(Long id) {

        try (PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(getDeleteStatement())) {

        preparedStatement.setLong(1, id);

        System.out.println(">> SQL: " + preparedStatement);


        preparedStatement.executeUpdate();

        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }
    }    
}