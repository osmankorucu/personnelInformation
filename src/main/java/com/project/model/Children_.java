package com.project.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-12-25T22:27:52.081+0300")
@StaticMetamodel(Children.class)
public class Children_ {
	public static volatile SingularAttribute<Children, Integer> chdID;
	public static volatile SingularAttribute<Children, String> chdName;
	public static volatile SingularAttribute<Children, Boolean> chdSex;
	public static volatile SingularAttribute<Children, Date> chdDateOfBirth;
}
