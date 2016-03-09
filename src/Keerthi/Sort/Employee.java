    package Keerthi.Sort;

    public class Employee implements Comparable {
        private int id;
        private String name;
        private int salary;

        public Employee() {
        }

        public Employee(String empName, int empSalary) {
            this.name = empName;
            this.salary = empSalary;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }


        @Override
        public int compareTo(Object o) {

            Employee employee = (Employee) o;

            if(this.getSalary() == employee.getSalary()){
                    return this.getName().compareTo(employee.getName());
            }
            else if( this.getSalary() < employee.getSalary()){
                    return -1;
            }
            else
                    return  1;
        }


        public boolean equals(Object o){
           if(o == null){
               return false;
           }
            else if(this == o){
               return  true;

           }
            if( o instanceof Employee ){
                Employee employee = (Employee) o;
                if(employee.getName() == this.getName()){
                    return  true;
                }
                else{
                    return  false;
                }
            }
            else{
                return  false;
            }
        }


    }

