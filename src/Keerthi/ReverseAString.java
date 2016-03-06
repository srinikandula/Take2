        package Keerthi;

        public class ReverseAString {

            public String reverseAString(String str){
                String s1= str ;
                String s2 = "";
                char c=0 ;
              // int l=  s1.length();
                for(int  i=s1.length()-1;i>=0; i--){
                   c =  s1.charAt(i);
                   // System.out.println(c);
                    s2 = s2 + c; //
                }
                // System.out.print(s2);
                return s2;
            }

            public static void main(String[] args) {
                ReverseAString r = new ReverseAString();
                String result = r.reverseAString("keerthi");
                System.out.println(result);
            }

        }
