package com.ithuang.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ithuang.entities.eo.UserEO;

/**  
  * ClassName: PersonRepository <br/>  
  * Function: TODO ADD FUNCTION. <br/>  
  * Reason: TODO ADD REASON(可选). <br/>  
  * date: 2019年7月19日 下午10:24:37 <br/>  
  *  
  * @author huangpf  
  * @version   
  * @since JDK 1.6  
  */
@Repository
public interface UserRepository
		extends JpaRepository<UserEO, Integer>, JpaSpecificationExecutor<UserEO>, Serializable {

	@Query("from UserEO where userName = :userName and passWord=:passWord")
	List<UserEO> queryByUserNameAndPassword(@Param("userName") String userName, @Param("passWord") String passWord);

	@Query("from UserEO where userName = :userName")
	List<UserEO> queryByUserName(@Param("userName") String userName);

}
