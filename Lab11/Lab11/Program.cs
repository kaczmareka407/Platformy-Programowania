using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Numerics;
using System.Diagnostics;
using System.IO;

namespace Lab11
{
    class Program
    {
        static void Main(string[] args)
        {
            //Zadanie 1
            Console.WriteLine("Zadanie 1: ");
            Category category = new Category(0, "NazwaKategorii", "Opis");
            Supplier supplier = new Supplier(0, "NazwaFirmy", "NazwaMiasta", "www.strona.com");
            Product product = new Product(0, "NazwaProductu", category, supplier,0.1m);
            Console.WriteLine(category.ToString());
            Console.WriteLine(supplier.ToString());
            //category.Id = "2"; nie mozna, poniewaz nie ma settera
            category.Name = "NowaNazwaKategorii";
            Console.WriteLine(product.ToString());
            product.Supplier.HomePage = "www.nowastrona.com";
            Console.WriteLine(product.ToString());

            //Zadanie 2
            Console.WriteLine("\n\n================================================");
            Console.WriteLine("Zadanie 2: ");
            Warehouse warehouse = new Warehouse();

            Category category1 = new Category(1, "NazwaKategorii1", "Opis1");
            Supplier supplier1 = new Supplier(1, "NazwaFirmy1", "NazwaMiasta1", "www.strona1.com");
            Product product1 = new Product(1, "NazwaProductu1", category1, supplier1, 1.0m);

            Category category2 = new Category(2, "NazwaKategorii2", "Opis2");
            Supplier supplier2 = new Supplier(2, "NazwaFirmy2", "NazwaMiasta2", "www.strona2.com");
            Product product2 = new Product(2, "NazwaProductu2", category2, supplier2, 2.0m);

            Category category3 = new Category(3, "NazwaKategorii3", "Opis3");
            Supplier supplier3 = new Supplier(3, "NazwaFirmy3", "NazwaMiasta3", "www.strona3.com");
            Product product3 = new Product(3, "NazwaProductu3", category3, supplier3, 3.0m);

            warehouse.add(product);
            warehouse.add(product1);
            warehouse.add(product2);
            warehouse.add(product3);

            warehouse.add(product1);

            Console.WriteLine("\nWarehouse: ");
            warehouse.print_warehouse();

            warehouse.update(product3, 5);


            Console.WriteLine("\nWarehouse: ");
            warehouse.print_warehouse();

            Console.WriteLine("Products in warehouse: "+warehouse.number_of_products());


            //Zadanie 3
            Console.WriteLine("\n\n================================================");
            Console.WriteLine("Zadanie 3: ");
            //Strong strong = new Strong(100000);

            Strong strong = new Strong(10);

            Stopwatch stopWatch = new Stopwatch();
            stopWatch.Start();
            BigInteger x = strong.calculate();
            stopWatch.Stop();
            TimeSpan ts = stopWatch.Elapsed;

            Console.WriteLine("Strong: "+x);
            strong.print_in_scientific_notation(x);

            string elapsedTime = String.Format("{0:00}:{1:00}:{2:00}.{3:00}",ts.Hours, ts.Minutes, ts.Seconds, ts.Milliseconds / 10);
            Console.WriteLine("RunTime " + elapsedTime);

            //Najwieksza wartosc silni: 28,24*10^456572, dla n = 100000 w czasie 7.55s

            //Zadanie 4
            Console.WriteLine("\n\n================================================");
            Console.WriteLine("Zadanie 4: ");


            CountWords countWords = new CountWords(new StreamReader("holmes.txt"));

            countWords.read();

            Console.ReadLine();
        }
    }
}
