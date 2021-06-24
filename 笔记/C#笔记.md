#### yield return用法
在 return 时，保存当前函数的状态，下次调用时继续从当前位置处理。
```C#
        static void Main(string[] args)
        { 
            foreach (var item in GetNumbers())
                Console.WriteLine("Main process. item = " + item);
        }
        
        static IEnumerable<int> GetNumbers()
        {
            // 以[0, 1, 2] 初始化数列 list
            Console.WriteLine("Initializating...");
            List<int> list = new List<int>();
            for (int i = 0; i < 3; i++)
                list.Add(i);

            // 每次 yield return 返回一个list的数据
            Console.WriteLine("Processing...");
            for (int i = 0; i < list.Count; i++)
            {
                Console.WriteLine("Yield called.");
                yield return list[i];
            }
            Console.WriteLine("Done.");
        }
/*输出
        Initializating...
        Processing...
        Yield called.
        Main process. item = 0
        Yield called.
        Main process. item = 1
        Yield called.
        Main process. item = 2
        Done.
*/
```