package bankaccountApp;

/* A Depiction of an API which will be available to us */
/* This will contain all the functions that will be available to us */
public interface IBaseRate {

	default double getBaseRate(){
		return 2.5;
	}
	
	
}
