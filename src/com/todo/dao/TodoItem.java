package com.todo.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TodoItem {
	private int id;
    private String title;
    private String desc;
    private String current_date;
    private String category;
    private String due_date;
    private int is_completed;
    private int is_important; 
    private int is_hurry;

    private SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd kk:mm:ss");

    public TodoItem(String category, String title, String desc, String due_date, int is_completed, int is_important, int is_hurry){
        this.category = category;    	
    	this.title=title;
        this.desc=desc;
    	this.due_date = due_date;
        this.current_date=f.format(new Date());
        this.is_completed = is_completed;
        this.is_important = is_important;
        this.is_hurry = is_hurry;
    }
    
    public String getCategory() {
    	return category;
    }
    
    public void setCategory(String category) {
    	this.category = category;
    }
    
    public String getDue_date() {
    	return due_date;
    }
    
    public void setDue_date(String due_date) {
    	this.due_date= due_date;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCurrent_date() {
        return current_date;
    }
    
    public void setCurrent_date(Date current_date) {
        this.current_date = f.format(current_date);
        
    }

    public void setCurrent_date(String current_date) {
        this.current_date = current_date;
    }
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
	public int getIs_completed() {
		return is_completed;
	}

	public void setIs_completed(int is_completed) {
		this.is_completed = is_completed;
	}
	
	public int getIs_important() {
		return is_important;
	}
	
	public void setIs_important(int is_important) {
		this.is_important = is_important;
	}
	
	public int getIs_hurry() {
		return is_hurry;
	}
	
	public void setIs_hurry(int is_hurry) {
		this.is_hurry = is_hurry;
	}
    @Override
    public String toString() {
    	if(this.is_completed == 1) {
    		if(this.is_important == 1) {
    			if(this.is_hurry == 1) return "[Important, Hurry, V] "+"["+category+"] "+ title + " - "+ desc + " - "+ due_date + " - " +current_date;
    			else return "[Important, V] "+"["+category+"] "+ title + " - "+ desc + " - "+ due_date + " - " +current_date;
    		}else {
    			if(this.is_hurry == 1) return "[Hurry, V] "+"["+category+"] "+ title + " - "+ desc + " - "+ due_date + " - " +current_date;
    			else return "[V] "+"["+category+"] "+ title + " - "+ desc + " - "+ due_date + " - " +current_date;
    		}
    	}else {
    		if(this.is_important ==1) {
    			if(this.is_hurry==1) return "[Important, Hurry] "+"["+category+"] "+ title + " - "+ desc + " - "+ due_date + " - " +current_date;
    			else return "[Important] "+"["+category+"] "+ title + " - "+ desc + " - "+ due_date + " - " +current_date;
    		}else {
    			if(this.is_hurry==1) return "[Hurry] "+"["+category+"] "+ title + " - "+ desc + " - "+ due_date + " - " +current_date;
    			else return "[]"+"["+category+"] "+ title + " - "+ desc + " - "+ due_date + " - " +current_date;
    		}
    	}
    }
    
    public String toSaveString() {
    	return is_important+"##"+is_hurry+"##"+is_completed+"##"+category+"##"+title + "##" + desc + "##" + due_date+"##"+current_date+ "\n";
    }
}
