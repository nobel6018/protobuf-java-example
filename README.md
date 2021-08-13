# Protobuf Java Example

## compile command
```shell
# project root에서 실행해야합니다
# 다른 경로에서 실행하면 상대경로이기 때문에 경로를 제대로 찾지 못합니다
protoc --java_out=src/main/java ./src/main/java/com/example/tutorial/schema/addressbook.proto
```

## references
- [Protocol Buffer Basics: Java](https://developers.google.com/protocol-buffers/docs/javatutorial)
- [Java Generated Code](https://developers.google.com/protocol-buffers/docs/reference/java-generated)


## 공부한 내용 가볍게 정리
### 1. proto 파일명과 message 이름이 동일하면 에러가 발생한다
- **addressbook**.proto 파일이라고 명명하고 .proto 파일에 message **AddressBook** 가 있으면
- **AddressBook**.java에는 public class **Addressbook**이 생성되서
- AddressBook.newBuilder()가 당연히 호출이 안된다

에러 메시지 내용
```text
[libprotobuf WARNING google/protobuf/compiler/java/java_file.cc:232] src/main/java/com/example/tutorial/addressbook/schema/addressbook.proto: The file's outer class name, "Addressbook", matches the name of one of the types declared inside it when case is ignored. This can cause compilation issues on Windows / MacOS. Please either rename the type or use the java_outer_classname option to specify a different outer class name for the .proto file to be safe.
```
