/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplellistesconcordion;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class System { 
   private Set<String> users;
	
   public System() {
    users = new HashSet<String>();   
   }
   public void addUser(String username) {
      users.add(username);
   }
	
   public Iterable<String> search(String searchString) {
      SortedSet<String> matches = new TreeSet<String>();
		
      for (String username : users) {
         if (username.contains(searchString)) {
            matches.add(username);
         }
      }
		
      return matches;
   }
}