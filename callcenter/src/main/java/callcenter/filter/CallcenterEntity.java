/**
 * 
 */
package callcenter.filter;

import java.sql.Date;

/**
 * @author firsov
 *
 */
public class CallcenterEntity {
	
	private String number;
	
	private Date dateDue;
	
	private Date dateCorrespondent;
					 
	private String correspondent;
	
	private String summary;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getDateDue() {
		return dateDue;
	}

	public void setDateDue(Date dateDue) {
		this.dateDue = dateDue;
	}

	public Date getDateCorrespondent() {
		return dateCorrespondent;
	}

	public void setDateCorrespondent(Date dateCorrespondent) {
		this.dateCorrespondent = dateCorrespondent;
	}

	public String getCorrespondent() {
		return correspondent;
	}

	public void setCorrespondent(String correspondent) {
		this.correspondent = correspondent;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public Builder newBuilder() {
		return new CallcenterEntity().new Builder();
	}
	
	public class Builder {

		private Builder() {
			super();
		}
		
		public Builder withNumber(String number) {
			CallcenterEntity.this.number = number;
			return this;
		}
		
		public Builder withDateDue(Date dateDue) {
			CallcenterEntity.this.dateDue = dateDue;
			return this;
		}
		
		public Builder withDateCorrespondent(Date dateCorrespondent) {
			CallcenterEntity.this.dateCorrespondent = dateCorrespondent;
			return this;
		}
		
		public Builder withCorrespondent(String correspondent) {
			CallcenterEntity.this.correspondent = correspondent;
			return this;
		}
		
		public Builder withSummary(String summary) {
			CallcenterEntity.this.summary = summary;
			return this;
		}
		
		public CallcenterEntity build() {
			return CallcenterEntity.this;
		}
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((correspondent == null) ? 0 : correspondent.hashCode());
		result = prime * result + ((dateCorrespondent == null) ? 0 : dateCorrespondent.hashCode());
		result = prime * result + ((dateDue == null) ? 0 : dateDue.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((summary == null) ? 0 : summary.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CallcenterEntity other = (CallcenterEntity) obj;
		if (correspondent == null) {
			if (other.correspondent != null)
				return false;
		} else if (!correspondent.equals(other.correspondent))
			return false;
		if (dateCorrespondent == null) {
			if (other.dateCorrespondent != null)
				return false;
		} else if (!dateCorrespondent.equals(other.dateCorrespondent))
			return false;
		if (dateDue == null) {
			if (other.dateDue != null)
				return false;
		} else if (!dateDue.equals(other.dateDue))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (summary == null) {
			if (other.summary != null)
				return false;
		} else if (!summary.equals(other.summary))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CallcenterEntity [number=" + number + ", dateDue=" + dateDue + ", dateCorrespondent="
				+ dateCorrespondent + ", correspondent=" + correspondent + ", summary=" + summary + "]";
	}
	
}
