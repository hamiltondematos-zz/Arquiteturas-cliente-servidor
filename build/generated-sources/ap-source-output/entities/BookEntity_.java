package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-11-14T14:08:33")
@StaticMetamodel(BookEntity.class)
public class BookEntity_ { 

    public static volatile SingularAttribute<BookEntity, Long> id;
    public static volatile SingularAttribute<BookEntity, String> title;
    public static volatile SingularAttribute<BookEntity, byte[]> bookFile;

}