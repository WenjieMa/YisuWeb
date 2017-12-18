package com.pojo;



/**
 * OrderSmallId entity. @author MyEclipse Persistence Tools
 */

public class OrderSmallId  implements java.io.Serializable {


    // Fields    

     private Integer did;
     private Integer gid;
     private Integer bid;
     private Integer uid;


    // Constructors

    /** default constructor */
    public OrderSmallId() {
    }

    
    /** full constructor */
    public OrderSmallId(Integer did, Integer gid, Integer bid, Integer uid) {
        this.did = did;
        this.gid = gid;
        this.bid = bid;
        this.uid = uid;
    }

   
    // Property accessors

    public Integer getDid() {
        return this.did;
    }
    
    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getGid() {
        return this.gid;
    }
    
    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getBid() {
        return this.bid;
    }
    
    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getUid() {
        return this.uid;
    }
    
    public void setUid(Integer uid) {
        this.uid = uid;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof OrderSmallId) ) return false;
		 OrderSmallId castOther = ( OrderSmallId ) other; 
         
		 return ( (this.getDid()==castOther.getDid()) || ( this.getDid()!=null && castOther.getDid()!=null && this.getDid().equals(castOther.getDid()) ) )
 && ( (this.getGid()==castOther.getGid()) || ( this.getGid()!=null && castOther.getGid()!=null && this.getGid().equals(castOther.getGid()) ) )
 && ( (this.getBid()==castOther.getBid()) || ( this.getBid()!=null && castOther.getBid()!=null && this.getBid().equals(castOther.getBid()) ) )
 && ( (this.getUid()==castOther.getUid()) || ( this.getUid()!=null && castOther.getUid()!=null && this.getUid().equals(castOther.getUid()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getDid() == null ? 0 : this.getDid().hashCode() );
         result = 37 * result + ( getGid() == null ? 0 : this.getGid().hashCode() );
         result = 37 * result + ( getBid() == null ? 0 : this.getBid().hashCode() );
         result = 37 * result + ( getUid() == null ? 0 : this.getUid().hashCode() );
         return result;
   }   





}