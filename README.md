# mockito-macros

A bunch of scala macros that simplify mockito code.

## How to get

* SBT (add to your `libraryDependencies`)

   ```
   "org.backuity" %% "mockito-macros" % "1.0" % "test"
   ```   
   
* Maven

   ```xml
   <dependency>
      <groupId>org.backuity</groupId>
      <artifactId>mockito-macros_2.11</artifactId>
      <version>1.0</version>
      <scope>test</scope>
   </dependency>
   ```

## Capture

Instead of writing the infamous ArgumentCaptor code such as:

```scala
val captor1 = ArgumentCaptor.forClass(classOf[SomeType])
org.mockito.Mockito.verify(myMock).myMockMethod(captor1.capture(),anyObject(), anyString())
val someValue : SomeType = captor1.getValue
```
   
you simply write:
   
```scala   
val someValue = capture[SomeType](myMock.myMockMethod(captor, any, any))
```
   
## Capture multiple parameters   

Instead of writing the infamous ArgumentCaptor code such as:

```scala
val captor1 = ArgumentCaptor.forClass(classOf[SomeType])
val captor2 = ArgumentCaptor.forClass(classOf[SomeOtherType])
org.mockito.Mockito.verify(myMock).myMockMethod(captor1.capture(),captor2.capture(),anyObject(), anyString())
val someValue : SomeType = captor1.getValue
val someOtherValue : SomeOtherType = captor2.getValue
```   
   
you simply write:
   
```scala
val (someValue, someOtherValue) = captureAll[SomeType :: SomeOtherType :: HNil](
        myMock.myMockMethod(captor, captor, any, any))
```

Where the type parameter of captureAll is a [shapeless HList](https://github.com/milessabin/shapeless/wiki/Feature-overview:-shapeless-2.0.0#heterogenous-lists).
