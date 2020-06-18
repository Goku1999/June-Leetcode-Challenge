/*Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.

IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;

Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.

IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits. The groups are separated by colons (":"). For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one. Also, we could omit some leading zeros among four hexadecimal digits and some low-case characters in the address to upper-case ones, so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros and using upper cases).

However, we don't replace a consecutive group of zero value with a single empty group using two consecutive colons (::) to pursue simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.

Besides, extra leading zeros in the IPv6 is also invalid. For example, the address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.

Note: You may assume there is no extra space or special characters in the input string.

Example 1:
Input: "172.16.254.1"

Output: "IPv4"

Explanation: This is a valid IPv4 address, return "IPv4".
Example 2:
Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"

Output: "IPv6"

Explanation: This is a valid IPv6 address, return "IPv6".
Example 3:
Input: "256.256.256.256"

Output: "Neither"

Explanation: This is neither a IPv4 address nor a IPv6 address.*/

class Solution 
{
    public String validIPAddress(String IP)
    {     
      if(IP.indexOf(".")!=-1)
      {   
         if(IP.charAt(0)!='.'&&IP.charAt(IP.length()-1)!='.')
         {        
            int count=0;          
            String[] a = IP.split("\\.");  
            for(int i=0;i<a.length;i++)
            {
               String s=a[i];
                if(s.length()>=1)
                {
                 if(s.indexOf('-')==-1&&((s.charAt(0)!='0'&&s.length()>=1)||     (s.length()==1&&s.charAt(0)=='0')))
                  {
                    try
                    {
                       int n=Integer.parseInt(s); 
                       if(n>=0&&n<=255)
                        count++; 
                     }
                    catch(NumberFormatException n)
                    {
                        return "Neither";
                     }
                   }
                  }
              }
              if(count==4)
                return "IPv4";
              else
                return "Neither";
            }
        }
        else if(IP.indexOf(":")!=-1)
        {
            int count =0;
            if(IP.charAt(0)!=':'&&IP.charAt(IP.length()-1)!=':')
            {
                String []a=IP.split("\\:");
              if(a.length==8)
              {
                for(int i=0;i<a.length;i++)
                {
                  String s=a[i];
                  if(s.length()>=1)
                  {
                    int flag=0;
                    boolean r=true;
                    for(int j=0;j<s.length();j++)
                     {
                        int v=s.charAt(j);
                        if((v>=48&&v<=57)||(v>=65&&v<=70)||(v>=97&&v<=102))
                         flag++;
                        else
                         r=false;
                       }
                      if(flag<=4&&r== true)
                       count++;
                    }
                  }
                 }
                   if(count==8)
                    return "IPv6";
                   else
                     return "Neither";
               }
          }
       return "Neither"; 
    }
}
