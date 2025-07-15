package com.kosmo;
//util 패키지가 collections을 포함해서 컬렉션 패키지라고도 한다.
import java.util.*;//* 와일드카드 (조커:모든카드로 가능)

public class L39Map {
    public static void main(String[] args) {
        // Map : Collections 인터페이스로 구현된 타입이 아님, 대신 Set을 포함
        // Collection (유용한 자료) Framework
        // Framework : 여러 라이브러리의 집합으로 새로운 규칙(*)을 생성, 유용, 어렵다
        // 컬렉션 프레임워크가 무엇인가요?
        // 개발자를 위한 유용한 자료들에 집합!!!

        //{key:value,key:value}
        //{"name":"경민", true:39 ,"name":"최경민"(X)}
        Map<String,Object> person=new HashMap<>();
        //HashSet Key로 사용되고 있어서 이름이 HashMap
        person.put("name","경민"); //key="name", value="경민"
        person.put("age",39);
        person.put("isMarried",true);
        System.out.println(person);//{isMarried=true, name=경민, age=39}
        //Map 데이터도 순서(index)가 없다.
        person.put("name","최경만");

        System.out.println(person);//{isMarried=true, name=최경만, age=39}
        //Key 가 Set 타입이라 중복데이터를 허용하지 않는다

        Set keys=person.keySet(); //keySet() : key들만 반환
        System.out.println(keys); //[isMarried, name, age]


        System.out.println(person.get("name"));
        System.out.println(person.get("isMarried"));
        System.out.println(person.get("age"));
        PersonClass p=new PersonClass();
        System.out.println(p);//{name:'최경민', isMarried:true, age:39}
        //Map과 필드가 Key와 같은 인스턴트는 아주 유사한 데이터다.
        //자바는 유사하지만 구분해서 사용

        //Map은 생성자와 메소드를 포함하지 않는다!
        Collection<Object> values=person.values();
        System.out.println(values); //[true, 최경만, 39]
        //containsKey,containsValue

        //반복문으로 Map을 탐색
        //Key를 이용하는 방법
        Iterator<String> keysIt=person.keySet().iterator();
        while (keysIt.hasNext()){
             String key=keysIt.next();
             Object value=person.get(key);
            System.out.println(key+":"+value);
        }
        for(String key: person.keySet()){
            Object value=person.get(key);
            System.out.println(key+"="+value);
        }
        //Entry //{[key,value],["name","경민"],["age",39]}
        System.out.println("entry Set");
        for(Map.Entry<String,Object> entry : person.entrySet()){
            //System.out.println(entry);
            String key=entry.getKey();
            Object value=entry.getValue();
            System.out.println(key+":::"+value);
        }
        //

    }
}

class PersonClass{
    String name="최경민";
    boolean isMarried=true;
    int age=39;

    @Override
    public String toString() {
        return "{" +
                "name:'" + name + '\'' +
                ", isMarried:" + isMarried +
                ", age:" + age +
                '}';
    }//Map과 인스턴스는 유사합니다.
}
