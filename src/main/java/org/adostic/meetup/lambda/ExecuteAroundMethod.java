package org.adostic.meetup.lambda;

import java.util.function.Consumer;

class ResourceNonLambda {
    public ResourceNonLambda() {System.out.println("create");}

    public void op1(){System.out.println("op1");}
    public void op2(){System.out.println("op2");}
    public void op3(){System.out.println("op3");}

    public void close(){System.out.println("cleanup");}
}
class ExecuteAroundMethodNonLambda {
    public static void main(String[] args) {
        ResourceNonLambda resourceNonLambda = new ResourceNonLambda();
        try {
            resourceNonLambda.op1();
            resourceNonLambda.op2();
            resourceNonLambda.op3();
        } finally {
            resourceNonLambda.close();
        }

    }
}

class Resource {
    private Resource() {System.out.println("create");}

    public Resource op1(){System.out.println("op1");return this;}
    public Resource op2(){System.out.println("op2");return this;}
    public Resource op3(){System.out.println("op3");return this;}

    private void close(){System.out.println("cleanup");}

    public static void use(Consumer<Resource> block){
        Resource resource = new Resource();
        try {
            block.accept(resource);
        } finally {
            resource.close();
        }
    }
}
public class ExecuteAroundMethod {

    public static void main(String[] args) {
        Resource.use(
                resource -> resource.op1()
                        .op2()
                        .op3()
        );
    }
}
