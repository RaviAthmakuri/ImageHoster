package ImageHoster.repository;

import ImageHoster.model.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

@Repository
public class CommentRepository {

    @PersistenceUnit(unitName = "imageHoster")
    EntityManagerFactory emf;

    public void createImageComment(Comments comments){
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            entityManager.persist(comments);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
        }
      //  return comments;
    }
}
