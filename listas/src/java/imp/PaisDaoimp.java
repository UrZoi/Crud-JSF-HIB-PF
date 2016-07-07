/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imp;

import dao.PaisDao;
import java.util.List;
import model.Paises;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author urzoi
 */
public class PaisDaoimp implements PaisDao {

    @Override
    public List<Paises> listaPaises() {
            List<Paises> listarPaises=null;
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction t = session.beginTransaction();
            String hql ="From Paises";
            
            try{
                listarPaises = session.createQuery(hql).list();
                t.commit();
                session.close();
                
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                t.rollback();
            
            }
                  
                
                   
            
            return listarPaises;
    }
    
}
