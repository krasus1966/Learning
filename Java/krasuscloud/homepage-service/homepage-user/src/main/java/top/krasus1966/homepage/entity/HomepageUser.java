package top.krasus1966.homepage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Krasus1966
 * @date 2019/12/23 16:18
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "homepage_user")
public class HomepageUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    @Basic
    @Column(name = "username",nullable = false)
    private String username;

    @Basic
    @Column(name = "email",nullable = false)
    private String email;

    @Basic
    @CreatedDate
    @Column(name = "create_time",nullable = false)
    private Date createTime;

    @Basic
    @LastModifiedDate
    @Column(name = "update_time",nullable = false)
    private Date updateTime;

    public HomepageUser(String username,String email){
        this.username = username;
        this.email = email;
    }

}
