import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class BasicJDBCDemo {

	/**
	 * @project sam test 05122017
	 */

		Connection conn;

		  public static void main(String[] args)
		  {
		    new BasicJDBCDemo();
		  }
		 
		  

		  public BasicJDBCDemo()
		  {
		    try
		    {
		      Class.forName("com.mysql.jdbc.Driver").newInstance();
		      String url = "jdbc:mysql://localhost/supplier";
		      conn = DriverManager.getConnection(url, "root", "");
		      doTests();
		      conn.close();
		    }
		    catch (ClassNotFoundException ex) {System.err.println(ex.getMessage());}
		    catch (IllegalAccessException ex) {System.err.println(ex.getMessage());}
		    catch (InstantiationException ex) {System.err.println(ex.getMessage());}
		    catch (SQLException ex)           {System.err.println(ex.getMessage());}
		  }

		  private void doTests()
		  {
			  String[] suppliers = new String[6];
			  
			  suppliers[0] =  doCreateTest();   
			  suppliers[1] =  doCreateTest2();
			  suppliers[2] =  doCreateTest3(); 
			  suppliers[3] =  doCreateTest4(); 
			  suppliers[4] =  doCreateTest5(); 
			  suppliers[5] =  doCreateTest6(); 
			  
		    System.out.println("created "+suppliers.length+" spaces for suppliers:");
		        for (int x=0;x<suppliers.length;x++){
		        	 
		            System.out.println(suppliers[x]);

		        }
			  
		        doInsertTest();   //doSelectTest();
			    doInsertTest2();  //doSelectTest2();
			    doInsertTest3();  //doSelectTest3();
			    doInsertTest4();  //doSelectTest4();
			    doInsertTest5();  //doSelectTest5();
			    doInsertTest6();  //doSelectTest6();
			    doCreateTest7(); 
			    
			    if (suppliers.length == 6){
			    System.out.print("\n cannot insert, spaces are fully occupied \n");
//			    doCreateTest7();  doInsertTest7();  
			    doInsertTest7(suppliers.length);
			    }
			    
			    doSelectMinLatencyTest();
			    doSelectMinPriceTest();
			    
			    doDeleteTable4Test();
			    doDeleteTable6Test();
			    
			    doInsertTest7allow();
			    doIndex2Test();
			    doSelectMinLatency5Test();
			    doSelectMinPrice1Test();
			    doIndex3Test();
		  }

		  private String doCreateTest()
		  {
		    String query = "CREATE TABLE `supplier`.`supplier-s001` ("+
		    		  "`price` int(10) DEFAULT NULL,"+
		    		  "`latency` int(10) DEFAULT NULL)";
		    try
		    {
		      Statement st = conn.createStatement();
		      st.executeUpdate(query); 
		    }
		    catch (SQLException ex)
		    {
		      System.err.println(ex.getMessage());
		    }
			return query;
			
		   }
	
		  private String doCreateTest2()
		  {
		    String query = "CREATE TABLE `supplier`.`supplier-s002` ("+
		    		  "`price` int(10) DEFAULT NULL,"+
		    		  "`latency` int(10) DEFAULT NULL)";
		    try
		    {
		    	  Statement st = conn.createStatement();
			      st.executeUpdate(query); 
		    }
		    catch (SQLException ex)
		    {
		      System.err.println(ex.getMessage());
		    }
			return query;
		
		  }
		  
		  private String doCreateTest3()
		  {
		    String query = "CREATE TABLE `supplier`.`supplier-s003` ("+
		    		  "`price` int(10) DEFAULT NULL,"+
		    		  "`latency` int(10) DEFAULT NULL)";
		    try
		    {
		    	  Statement st = conn.createStatement();
			      st.executeUpdate(query); 
		    }
		    catch (SQLException ex)
		    {
		      System.err.println(ex.getMessage());
		    }
			return query;
			
		  }
		  
		  private String doCreateTest4()
		  {
		    String query = "CREATE TABLE `supplier`.`supplier-s004` ("+
		    		  "`price` int(10) DEFAULT NULL,"+
		    		  "`latency` int(10) DEFAULT NULL)";
		    try
		    {
		    	  Statement st = conn.createStatement();
			      st.executeUpdate(query); 
		    }
		    catch (SQLException ex)
		    {
		      System.err.println(ex.getMessage());
		    }
			return query;
			
		  }
		  
		  private String doCreateTest5()
		  {
		    String query = "CREATE TABLE `supplier`.`supplier-s005` ("+
		    		  "`price` int(10) DEFAULT NULL,"+
		    		  "`latency` int(10) DEFAULT NULL)";
		    try
		    {
		    	  Statement st = conn.createStatement();
			      st.executeUpdate(query); 
		    }
		    catch (SQLException ex)
		    {
		      System.err.println(ex.getMessage());
		    }
			return query;
			
		  }
		  
		  private String doCreateTest6()
		  {
			  String query = "CREATE TABLE `supplier`.`supplier-s006` ("+
		    		  "`price` int(10) DEFAULT NULL,"+
		    		  "`latency` int(10) DEFAULT NULL)";
		    try
		    {
		    	  Statement st = conn.createStatement();
			      st.executeUpdate(query); 
		    }
		    catch (SQLException ex)
		    {
		      System.err.println(ex.getMessage());
		    }
			return query;
			
		  }
		  
		  private String doCreateTest7()
		  {
		    String query = "CREATE TABLE `supplier`.`supplier-s007` ("+
		    		  "`price` int(10) DEFAULT NULL,"+
		    		  "`latency` int(10) DEFAULT NULL)";
		    try
		    {
		    	  Statement st = conn.createStatement();
			      st.executeUpdate(query); 
		    }
		    catch (SQLException ex)
		    {
		      System.err.println(ex.getMessage());
		    }
			return query;
			
		  }
		
		  private void doSelectMinLatencyTest()
		  {
		   
		    String query = "SELECT LATENCY, PRICE FROM `supplier`.`supplier-s006`";
		    try
		    {
		      Statement st = conn.createStatement();
		      ResultSet rs = st.executeQuery(query);
		      while (rs.next())
		      {
		        float n = rs.getFloat("price");
		        int s = rs.getInt("latency");
		        System.out.println("\n Min latency: Supplier-S006 "+ n + "   " + s);
		      }
		    }
		    catch (SQLException ex)
		    {
		      System.err.println(ex.getMessage());
		    }
		  }
		  
		  private void doSelectMinLatency5Test()
		  {
		   
		    String query = "SELECT LATENCY, PRICE FROM `supplier`.`supplier-s005`";
		    try
		    {
		      Statement st = conn.createStatement();
		      ResultSet rs = st.executeQuery(query);
		      while (rs.next())
		      {
		        float n = rs.getFloat("price");
		        int s = rs.getInt("latency");
		        System.out.println("\n Min latency: Supplier-S005 "+ n + "   " + s);
		      }
		    }
		    catch (SQLException ex)
		    {
		      System.err.println(ex.getMessage());
		    }
		  }
		  
		  private void doSelectMinPriceTest()
		  {
		    
		    String query = "SELECT LATENCY, PRICE FROM `supplier`.`supplier-s004`";
		    try
		    {
		      Statement st = conn.createStatement();
		      ResultSet rs = st.executeQuery(query);
		      while (rs.next())
		      {
		        float n = rs.getFloat("price");
		        int s = rs.getInt("latency");
		        System.out.println("\n Min Price: Supplier-S004 "+ n + "   " + s);
		      }
		    }
		    catch (SQLException ex)
		    {
		      System.err.println(ex.getMessage());
		    }
		  }
		  
		  private void doSelectMinPrice1Test()
		  {
		    
		    String query = "SELECT LATENCY, PRICE FROM `supplier`.`supplier-s001`";
		    try
		    {
		      Statement st = conn.createStatement();
		      ResultSet rs = st.executeQuery(query);
		      while (rs.next())
		      {
		        float n = rs.getFloat("price");
		        int s = rs.getInt("latency");
		        System.out.println("\n Min Price: Supplier-S001 "+ n + "   " + s);
		      }
		    }
		    catch (SQLException ex)
		    {
		      System.err.println(ex.getMessage());
		    }
		  }
		  
		  private void doSelectTest()
		  {
		    String query = "SELECT LATENCY, PRICE FROM `supplier`.`supplier-s001`";
		    try
		    {
		      Statement st = conn.createStatement();
		      ResultSet rs = st.executeQuery(query);
		      while (rs.next())
		      {
		        float n = rs.getFloat("price");
		        int s = rs.getInt("latency");
		        System.out.println("\n 1. Supplier-S001 "+ n + "   " + s);
		      }
		    }
		    catch (SQLException ex)
		    {
		      System.err.println(ex.getMessage());
		    }
		  }

		  private void doSelectTest2()
		  {
		    String query = "SELECT LATENCY, PRICE FROM `supplier`.`supplier-s002`";
		    try
		    {
		      Statement st = conn.createStatement();
		      ResultSet rs = st.executeQuery(query);
		      while (rs.next())
		      {
		    	  float n = rs.getFloat("price");
			        int s = rs.getInt("latency");
			        System.out.println("\n 2. Supplier-S002 "+ n + "   " + s);
		      }
		    }
		    catch (SQLException ex)
		    {
		      System.err.println(ex.getMessage());
		    }
		  }
		  
		  private void doSelectTest3()
		  {
		    String query = "SELECT LATENCY, PRICE FROM `supplier`.`supplier-s003`";
		    try
		    {
		      Statement st = conn.createStatement();
		      ResultSet rs = st.executeQuery(query);
		      while (rs.next())
		      {
		    	  float n = rs.getFloat("price");
			        int s = rs.getInt("latency");
			        System.out.println("\n 3. Supplier-S003 "+ n + "   " + s);
		      }
		    }
		    catch (SQLException ex)
		    {
		      System.err.println(ex.getMessage());
		    }
		  }
		  
		  private void doSelectTest4()
		  {
		    String query = "SELECT LATENCY, PRICE FROM `supplier`.`supplier-s004`";
		    try
		    {
		      Statement st = conn.createStatement();
		      ResultSet rs = st.executeQuery(query);
		      while (rs.next())
		      {
		    	  float n = rs.getFloat("price");
			        int s = rs.getInt("latency");
			        System.out.println("\n 4. Supplier-S004 "+ n + "   " + s);
		      }
		    }
		    catch (SQLException ex)
		    {
		      System.err.println(ex.getMessage());
		    }
		  }
		  
		  private void doSelectTest5()
		  {
//		    System.out.println("[OUTPUT FROM SELECT SUPPLIER-S005]");
		    String query = "SELECT LATENCY, PRICE FROM `supplier`.`supplier-s005`";
		    try
		    {
		      Statement st = conn.createStatement();
		      ResultSet rs = st.executeQuery(query);
		      while (rs.next())
		      {
		    	  float n = rs.getFloat("price");
			        int s = rs.getInt("latency");
			        System.out.println("\n 5. Supplier-S005 "+ n + "   " + s);
		      }
		    }
		    catch (SQLException ex)
		    {
		      System.err.println(ex.getMessage());
		    }
		  }
		  
		  private void doSelectTest6()
		  {
//		    System.out.println("[OUTPUT FROM SELECT SUPPLIER-S006]");
		    String query = "SELECT LATENCY, PRICE FROM `supplier`.`supplier-s006`";
		    try
		    {
		      Statement st = conn.createStatement();
		      ResultSet rs = st.executeQuery(query);
		      while (rs.next())
		      {
		    	  float n = rs.getFloat("price");
			        int s = rs.getInt("latency");
			        System.out.println("\n 6. Supplier-S006 "+ n + "   " + s);
		      }
		    }
		    catch (SQLException ex)
		    {
		      System.err.println(ex.getMessage());
		    }
		  }
		  
		
		  
		  private void doInsertTest()
		  {
		    System.out.print("\n Insert as supplier 1");
		    try
		    {
		      Statement st = conn.createStatement();
		      st.executeUpdate("INSERT INTO `supplier`.`supplier-s001` (`price` ,`latency`) " +
		                       "VALUES ('1500','100')");
		    }
		    catch (SQLException ex)
		    {
		      System.err.println(ex.getMessage());
		    }
		  }
		  
		  private void doInsertTest2()
		  {
		    System.out.print("\n Insert as supplier 2");
		    try
		    {
		      Statement st = conn.createStatement();
		      st.executeUpdate("INSERT INTO `supplier`.`supplier-s002` (`price` ,`latency`) " +
		                       "VALUES ('2500','300')");
		    }
		    catch (SQLException ex)
		    {
		      System.err.println(ex.getMessage());
		    }
		  }
		  
		  private void doInsertTest3()
		  {
		    System.out.print("\n Insert as supplier 3");
		    try
		    {
		      Statement st = conn.createStatement();
		      st.executeUpdate("INSERT INTO `supplier`.`supplier-s003` (`price` ,`latency`) " +
		                       "VALUES ('1750','250')");
		    }
		    catch (SQLException ex)
		    {
		      System.err.println(ex.getMessage());
		    }
		  }
		  
		  private void doInsertTest4()
		  {
		    System.out.print("\n Insert as supplier 4");
		    try
		    {
		      Statement st = conn.createStatement();
		      st.executeUpdate("INSERT INTO `supplier`.`supplier-s004` (`price` ,`latency`) " +
		                       "VALUES ('1250','1000')");
		    }
		    catch (SQLException ex)
		    {
		      System.err.println(ex.getMessage());
		    }
		  }
		  
		  private void doInsertTest5()
		  {
		    System.out.print("\n Insert as supplier 5");
		    try
		    {
		      Statement st = conn.createStatement();
		      st.executeUpdate("INSERT INTO `supplier`.`supplier-s005` (`price` ,`latency`) " +
		                       "VALUES ('1850','95')");
		    }
		    catch (SQLException ex)
		    {
		      System.err.println(ex.getMessage());
		    }
		  }
		  
		  private void doInsertTest6()
		  {
		    System.out.print("\n Insert as supplier 6");
		    try
		    {
		      Statement st = conn.createStatement();
		      st.executeUpdate("INSERT INTO `supplier`.`supplier-s006` (`price` ,`latency`) " +
		    		  "VALUES ('1900','34')");
		    }
		    catch (SQLException ex)
		    {
		      System.err.println(ex.getMessage());
		    }
		  }
		  
		  private void doInsertTest7allow()
		  {
		    System.out.print("\n Insert as supplier 7");
		    try
		    {
		      Statement st = conn.createStatement();
		      st.executeUpdate("INSERT INTO `supplier`.`supplier-s007` (`price` ,`latency`) " +
		    		  "VALUES ('3000','123')");
		    }
		    catch (SQLException ex)
		    {
		      System.err.println(ex.getMessage());
		    }
		  }
		  
		  private void doInsertTest7(int suppliers)
		  {
//		    System.out.print("\n cannot insert, spaces are fully occupied");
		    try
		    {
		    	if (suppliers != 6){
		    		 Statement st = conn.createStatement();
				      st.executeUpdate("INSERT INTO `supplier`.`supplier-s007` (`price` ,`latency`) " +
				    		  "VALUES ('3000 ','123')");

				    }
		     
		    }
		    catch (SQLException ex)
		    {
		      System.err.println(ex.getMessage());
		    }
		  }
		  
		  private void doIndexTest()
		  {
		    System.out.print("\n index Supplier name price latency");
		    doSelectTest();
		    doSelectTest2();
		    doSelectTest3();
		    doSelectTest4();
		    doSelectTest5();
		    doSelectTest6();
		  }
		  
		  private void doIndex2Test()
		  {
		    System.out.print("\n index Supplier name price latency");
		    doSelectTest();
		    doSelectTest2();
		    doSelectTest3();
		    doSelectTest4();
		    doSelectTest5();
		  }
		 
		  private void doIndex3Test()
		  {
		    System.out.print("\n index Supplier name price latency");
		    doSelectTest();
		    doSelectTest3();
		  }
		  
		 
		 private void doDropTableTest()
		  {
//		    System.out.print("\n[Performing DELETE] ... ");
		    try
		    {
		      Statement st = conn.createStatement();
		      st.executeUpdate("DROP TABLE `supplier`.`supplier-s007`");
		    }
		    catch (SQLException ex)
		    {
		      System.err.println(ex.getMessage());
		    }
		  }
		 
		 private void doDeleteTable4Test()
		  {
		    System.out.print("\n Delete Supplier-S004");
		    try
		    {
		      Statement st = conn.createStatement();
		      st.executeUpdate("DELETE FROM `supplier`.`supplier-s004`");
		    }
		    catch (SQLException ex)
		    {
		      System.err.println(ex.getMessage());
		    }
		  }
		 
		 private void doDeleteTable6Test()
		  {
		    System.out.print("\n Delete 6");
		    try
		    {
		      Statement st = conn.createStatement();
		      st.executeUpdate("DELETE FROM `supplier`.`supplier-s006`");
		    }
		    catch (SQLException ex)
		    {
		      System.err.println(ex.getMessage());
		    }
		  }

       }
