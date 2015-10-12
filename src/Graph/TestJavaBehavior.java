package Graph;

/**
 * Created by livetolove128 on 11/10/15.
 */
public class TestJavaBehavior {
        private int a;
        private int b;

        public TestJavaBehavior(int a, int b){
            this.a = a;
            this.b = b;
        }

        public int getA(){
            return this.a;
        }

        public int getB(){
            return this.b;
        }

        public void setA(int a){
            this.a = a;
        }

        public void setB(int b){
            this.b = b;
        }

        public void change(TestJavaBehavior a){
            a.setA(8);
        }

        public TestJavaBehavior getThis(){
            return this;
        }

}
