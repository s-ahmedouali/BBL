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
import java.sql.Date;
import org.example.demo.model.User;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "EVENT")
@XmlRootElement
public class Event implements Serializable
{

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id", updatable = false, nullable = false)
   private Long id;
   @Version
   @Column(name = "version")
   private int version;

   @Column(name = "title", nullable = false)
   private String title;

   @Column(name = "description")
   private String description;

   @Column(name = "DATE", nullable = false)
   private Date date;

   @Column(name = "adress", nullable = false)
   private String adress;

   @ManyToMany
   private Set<User> talkers = new HashSet<User>();

   @OneToMany
   private Set<User> participants = new HashSet<User>();

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
      if (!(obj instanceof Event))
      {
         return false;
      }
      Event other = (Event) obj;
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

   public String getTitle()
   {
      return title;
   }

   public void setTitle(String title)
   {
      this.title = title;
   }

   public String getDescription()
   {
      return description;
   }

   public void setDescription(String description)
   {
      this.description = description;
   }

   public Date getDate()
   {
      return date;
   }

   public void setDate(Date date)
   {
      this.date = date;
   }

   public String getAdress()
   {
      return adress;
   }

   public void setAdress(String adress)
   {
      this.adress = adress;
   }

   @Override
   public String toString()
   {
      String result = getClass().getSimpleName() + " ";
      if (title != null && !title.trim().isEmpty())
         result += "title: " + title;
      if (description != null && !description.trim().isEmpty())
         result += ", description: " + description;
      if (adress != null && !adress.trim().isEmpty())
         result += ", adress: " + adress;
      return result;
   }

   public Set<User> getTalkers()
   {
      return this.talkers;
   }

   public void setTalkers(final Set<User> talkers)
   {
      this.talkers = talkers;
   }

   public Set<User> getParticipants()
   {
      return this.participants;
   }

   public void setParticipants(final Set<User> participants)
   {
      this.participants = participants;
   }
}