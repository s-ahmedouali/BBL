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
import org.example.demo.model.User;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "USER_DETAIL")
@XmlRootElement
public class UserDetail implements Serializable
{

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id", updatable = false, nullable = false)
   private Long id;
   @Version
   @Column(name = "version")
   private int version;

   @OneToOne(cascade = CascadeType.ALL)
   private User User;

   @Column(name = "lastname", nullable = false)
   private String lastName;

   @Column(name = "firstname", nullable = false)
   private String firstName;

   @Column(name = "bio")
   private String bio;

   @Column(nullable = false)
   private String email;

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
      if (!(obj instanceof UserDetail))
      {
         return false;
      }
      UserDetail other = (UserDetail) obj;
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

   public User getUser()
   {
      return User;
   }

   public void setUser(User User)
   {
      this.User = User;
   }

   public String getLastName()
   {
      return lastName;
   }

   public void setLastName(String lastName)
   {
      this.lastName = lastName;
   }

   public String getFirstName()
   {
      return firstName;
   }

   public void setFirstName(String firstName)
   {
      this.firstName = firstName;
   }

   public String getBio()
   {
      return bio;
   }

   public void setBio(String bio)
   {
      this.bio = bio;
   }

   public String getEmail()
   {
      return email;
   }

   public void setEmail(String email)
   {
      this.email = email;
   }

   @Override
   public String toString()
   {
      String result = getClass().getSimpleName() + " ";
      if (lastName != null && !lastName.trim().isEmpty())
         result += "lastName: " + lastName;
      if (firstName != null && !firstName.trim().isEmpty())
         result += ", firstName: " + firstName;
      if (bio != null && !bio.trim().isEmpty())
         result += ", bio: " + bio;
      if (email != null && !email.trim().isEmpty())
         result += ", email: " + email;
      return result;
   }
}