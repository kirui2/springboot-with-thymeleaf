package com.kemal.spring.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Keno&Kemo on 30.09.2017..
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User findByEmailAndIdNot(String email, Long id);

    User findByUsernameAndIdNot(String username, Long id);

    Page<User> findByUsernameContainingOrderByIdAsc(String username, Pageable pageable);

    Page<User> findByEmailContainingOrderByIdAsc(String email, Pageable pageable);

    Page<User> findByNameContainingOrderByIdAsc(String name, Pageable pageable);

    Page<User> findByBankContainingOrderByIdAsc(String bank, Pageable pageable);

    //region Find eagerly
    //==========================================================================
    @Query("SELECT u FROM User u JOIN FETCH u.roles")
    List<User> findAllEagerly();


//    public default List<User> findAllEagerly(){
//        return jdbcTemplate.query("select *,enabled from khetia2 where enabled=0", new RowMapper<User>() {
//            public User mapRow(ResultSet rs, int row) throws SQLException {
//                User user = new User();
//                user.setBank(rs.getString());
////                payments.setId(rs.getInt(1));
////                payments.setAmount(rs.getDouble(2));
//
//                return user;
//            }
//
//        });
//
//    }


    @Query("SELECT u FROM User u JOIN FETCH u.roles WHERE u.email = (:email)")
    User findByEmailEagerly(@Param("email") String email);

    @Query("SELECT u FROM User u JOIN FETCH u.roles WHERE u.id = (:id)")
    User findByIdEagerly(@Param("id") Long id);
    //==========================================================================
    //endregion


}
