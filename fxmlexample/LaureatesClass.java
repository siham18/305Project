/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlexample;

/**
 *
 * @author Siham
 */
public class LaureatesClass {
    // I don't think I would keep ID and share as ints. When displaying
    // them in a table that will cause a bunch of grief. Can use string
    // to int if you need to do a compare. I think I would change them
    // to String here.
    public int id;
    public String firstname;
    public String surname;
    public String bornCountry;
    public String bornCountryCode;
    public String bornCity;
    public String diedCountry;
    public String diedCountryCode;
    public String diedCity;
    public String bornDate;
    public String bornDateTo;
    public String diedDateTo;
    public String motivation;
    public String gender;
    public String affiliation;
    public int share;
}
