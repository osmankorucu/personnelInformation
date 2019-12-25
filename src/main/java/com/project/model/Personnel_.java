package com.project.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-12-25T22:27:52.141+0300")
@StaticMetamodel(Personnel.class)
public class Personnel_ {
	public static volatile SingularAttribute<Personnel, Integer> prsId;
	public static volatile SingularAttribute<Personnel, String> prsName;
	public static volatile SingularAttribute<Personnel, String> prsSurname;
	public static volatile SingularAttribute<Personnel, Boolean> prsSex;
	public static volatile SingularAttribute<Personnel, Date> prsDateOfBirth;
	public static volatile SingularAttribute<Personnel, String> prsEMail;
	public static volatile SingularAttribute<Personnel, String> prsPhoneNumber;
	public static volatile SingularAttribute<Personnel, String> prsAddress;
	public static volatile ListAttribute<Personnel, EducationStatus> prsEducationStatus;
	public static volatile ListAttribute<Personnel, Children> prsChildren;
	public static volatile SingularAttribute<Personnel, Boolean> prsIsMarried;
}
