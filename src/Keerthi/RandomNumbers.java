        package Keerthi;

        public class RandomNumbers {

            public static void main(String[] args) {
                /*for (int i = 1; i <= 10; i++) {
                    double d = Math.random() * 100;
                    int l = (int) Math.round(d);
                    System.out.println(l);
                    int[] ar = new int[]{l};
                    //ar[]  = sort(int[] ar);
                    int largest = l;
                    int smallest = l;

                    if (l > largest) {
                        largest = l;

                    } else if (l < smallest) {
                        smallest = l;
                    }

                    System.out.println("largest is" + largest);
                    System.out.println("smallest is" + smallest);
                }*/

                int largest = 0;
                int smallest = 0;
                int[] ar = new int[10];

                for( int i = 0; i <= 9; i++){
                    double d = Math.random() * 100;
                    int l = (int) Math.round(d);
                    //System.out.println(d);
                    System.out.println(l);

                        ar[i] =l;
                        if (smallest ==0){
                            smallest = l;
                        }
                     if (l > largest) {
                            largest = l;
                        }

                    if (l < smallest) {
                            smallest = l;
                        }

                }

                System.out.println("largest is" + largest);
                System.out.println("smallest is" + smallest);
            }

        }