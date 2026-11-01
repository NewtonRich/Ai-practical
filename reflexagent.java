public class reflexagent{
    public static void main(String[] args) {
        String A = "Dirty";
        String B = "Clean";
        char Location = 'A';
        if(Location == 'A'){
            if(A == "Dirty"){
                System.out.println("Clean room A");
                A = "Clean";
            }else{
                System.out.println("Room A is clean");

            }

        }
        if(Location == 'B'){
            if(B == "Dirty"){
                System.out.println("Clean room B");
                B = "Clean";
            }else{
                System.out.println("Room B is clean");
            }

        }
        System.out.println("Final State: A = " + A + ", B = " + B);
    }
}