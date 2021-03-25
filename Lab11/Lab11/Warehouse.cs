using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab11
{
    class Warehouse
    {
        private Dictionary<Product, int> warehouse = new Dictionary<Product, int>();


        public Warehouse()
        {
            warehouse = new Dictionary<Product, int>();
        }

        internal Dictionary<Product, int> WArehouse { get => warehouse; }


        //(a) dodawania nowych produktów,
        public void add(Product product)
        {
            if (!warehouse.ContainsKey(product))
                {
                warehouse.Add(product, 1);
                }
            else
            {
                warehouse[product] += 1;
            }
        }

        //(b) aktualizacji stanu magazynowego produktu,
        public void update(Product product, int number)
        {
            if (warehouse.ContainsKey(product))
            {
                warehouse[product] = number;
            }
            else
            {
                Console.WriteLine("This product is not already in warehouse");
            }
        }
        //(c) zwracania liczby wszystkich produktów
        public int number_of_products()
        {
            int sum = 0;
            foreach (var x in warehouse)
            {
                sum += x.Value;
            }
            return sum;
        }
        //(d) wypisywania aktualnego spisu produktów(wraz z ich stanem magazynowym).
        public void print_warehouse()
        {
            foreach (var x in warehouse)
            {
                Console.WriteLine("Product: " + x.Key.Name + " Number: " + x.Value);
            }
        }
    }
}
