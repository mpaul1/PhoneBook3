package com.claim;

public class Person implements Comparable
{
	private String fname = "";
	private String mname = "";
	private String lname = "";
	private String telephone = "";
	private Address address;

	public Person(String string)
	{

		/* John Doe, 114 Market St, St Louis, MO, 63403, 6366435698 
		 * John E Doe, 324 Main St, St Charles, MO,63303, 8475390126 
		 * John Michael West Doe, 574 Pole ave, St. Peters, MO, 63333, 5628592375
		 */
		String[] extractedvalues = string.split(",");
		
		String[] namefields = extractedvalues[0].split(" ");
				for (int j = 0; j < namefields.length; j++)
				{
					if(j==0) {this.fname = namefields[j];}
					if(j>0&&j<namefields.length-1){this.mname += " "+namefields[j];}
					if(j==namefields.length-1) {this.lname =namefields[j];}

				}
				this.mname = this.mname.strip();
				
		Address a = new Address(extractedvalues[1].strip(),extractedvalues[2].strip(),extractedvalues[3].strip(),extractedvalues[4].strip());
		this.address=a;
		
		this.telephone = extractedvalues[5].strip();
	}

	public String getFname()
	{
		return fname;
	}

	public void setFname(String fname)
	{
		this.fname = fname;
	}

	public String getMname()
	{
		return mname;
	}

	public void setMname(String mname)
	{
		this.mname = mname;
	}

	public String getLname()
	{
		return lname;
	}

	public void setLname(String lname)
	{
		this.lname = lname;
	}

	public String getTelephone()
	{
		return telephone;
	}

	public void setTelephone(String telephone)
	{
		this.telephone = telephone;
	}

	public Address getAddress()
	{
		return address;
	}

	public void setAddress(Address address)
	{
		this.address = address;
	}

	public String getFullName()
	{
		return fname + " " + mname + " " + lname;
	}

	@Override
	public String toString()
	{
		return fname + " " + mname + " " + lname + " " + telephone.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3") + " " + address;

	}
	

	@Override
	public int compareTo(Object o)
	{

		return this.getFullName().compareTo(((Person) o).getFullName());
	}

}
