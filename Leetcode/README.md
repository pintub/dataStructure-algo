### Observations / Tips `'>' implies Better in terms of Performance)`
  - String.toCharArray/Array navigation vs String.charAt(index) `TODO Need to verify this using JMH`
  - Math.pow(x) > x * x
  - Digit Iteration
    - Normal way by dividing 10 and get digits Unit place to Higher Place `Better Performance`
    - Convert to String and then to CharArray , and Can get digits in either Order
  - Char Number to Number
    - Character.getNumericValue(1) > Integer.parseInt(""+1)
  - Power of Array as Map
    - Can be used instead of HashMap `Key -> index and, Value -> Array value`
    - Can be used instead of Sorting
  - Binary to Decimal using Left Shift Operator  [Example](./src/main/java/Solution1290.java)
  - Decimal to Binary
    - To get Count of 1 bits: Integer.bitCount(int) `Uses bit shifting` > Dividing By 2 and Iterating
    - To get Binary Format: Integer.toBinaryString(int) `Again uses bit shifting`
    
