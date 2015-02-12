### Problem
write a function to called to generate integer one by one in increasing order


### Analysis
1. 前->末遍历 记录到目前位置，使用过的 digit
2. 末->前遍历 对每一个数字，查找是否存在，大于自己切未使用的数
  - 如找到, break
  - 如果 step 2 到了头，且头是9，需要进位
3. 从break的位置开始 to 末遍历，依次选取最小且未使用的数字
