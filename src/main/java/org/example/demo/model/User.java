package org.example.demo.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import java.lang.Override;
import org.example.demo.State;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "USER")
@XmlRootElement
public class User implements Serializable
{

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id", updatable = false, nullable = false)
   private Long id;
   @Version
   @Column(name = "version")
   private int version;

   @Column(name = "login", nullable = false)
   private String login;

   @Column(name = "password", nullable = false)
   private String password;

   @Enumerated
   @Column(name = "state")
   private State State;

   @OneToOne(mappedBy = "User")
   private UserDetail detail;

   public Long getId()
   {
      return this.id;
   }

   public void setId(final Long id)
   {
      this.id = id;
   }

   public int getVersion()
   {
      return this.version;
   }

   public void setVersion(final int version)
   {
      this.version = version;
   }

   @Override
   public boolean equals(Object obj)
   {
      if (this == obj)
      {
         return true;
      }
      if (!(obj instanceof User))
      {
         return false;
      }
      User other = (User) obj;
      if (id != null)
      {
         if (!id.equals(other.id))
         {
            return false;
         }
      }
      return true;
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((id == null) ? 0 : id.hashCode());
      return result;
   }

   public String getLogin()
   {
      return login;
   }

   public void setLogin(String login)
   {
      this.login = login;
   }

   public String getPassword()
   {
      return password;
   }

   public void setPassword(String password)
   {
      this.password = password;
   }

   public State getState()
   {
      return State;
   }

   public void setState(State State)
   {
      this.State = State;
   }

   public UserDetail getDetail()
   {
      return detail;
   }

   public void setDetail(UserDetail detail)
   {
      this.detail = detail;
   }

   @Override
   public String toString()
   {
      String result = getClass().getSimpleName() + " ";
      if (login != null && !login.trim().isEmpty())
         result += "login: " + login;
      if (password != null && !password.trim().isEmpty())
         result += ", password: " + password;
      return result;
   }
}