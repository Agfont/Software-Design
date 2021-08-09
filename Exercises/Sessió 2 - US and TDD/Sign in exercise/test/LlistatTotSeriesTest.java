/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import exemplellistesconcordion.System;

import org.junit.Before;
import org.junit.Test;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
/**
 *
 * @author anna
 */
public class LlistatTotSeriesTest {
    private  System list;
    
    @Before
    public void init(){
        list = new System();
    }
    
    @Test
    public void setUpUser(String name) {
        list.addUser(name);
    }
    
    @Test
    public Iterable<String> getSearchResultsFor(String toSearch) {
        return list.search(toSearch);
    }
    
}
