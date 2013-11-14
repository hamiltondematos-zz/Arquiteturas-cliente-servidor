/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.BookEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hamilton.matos
 */
@Stateless
public class BookEntityFacade extends AbstractFacade<BookEntity> {

    @PersistenceContext(unitName = "FileUploadExemploPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BookEntityFacade() {
        super(BookEntity.class);
    }

}
