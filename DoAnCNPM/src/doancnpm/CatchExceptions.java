/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doancnpm;

/**
 *
 * @author manng
 */
public class CatchExceptions {
    public static int count(String s)
    {
        int i = 0, count = 1;
        char[] s1 = s.toCharArray(); 
        while(s1[i] == ' ')
        {
            i++;
        }

        for (int j = i; j < s1.length - 1; j++)
        {
            if(s1[j] == ' ' && s1[j + 1] != ' ')
            {
                count++;
            }
        }
        return count;
    } 
}
