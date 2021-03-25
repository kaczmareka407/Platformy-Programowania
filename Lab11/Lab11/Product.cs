using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab11
{
    class Product
    {
        private int id;
        private string name;
        private Category category;
        private Supplier supplier;
        private Decimal unitPrice;

        public Product(int ID, string Name, Category CAtegory, Supplier SUpplier, Decimal UnitPrice)
        {
            id = ID;
            name = Name;
            category = CAtegory;
            supplier = SUpplier;
            unitPrice = UnitPrice;
        }

        public int Id { get => id; }
        public string Name { get => name; set => name = value; }
        public decimal UnitPrice { get => unitPrice; set => unitPrice = value; }
        internal Category Category { get => category; set => category = value; }
        internal Supplier Supplier { get => supplier; set => supplier = value; }

        public override string ToString()
        {
            return "id: " + id + " name: " + name + " \n" +
                "Category: " + category.ToString() + " \n" +
                "Supplier: " + supplier.ToString() + " \n" +
                "UnitPrice: " + unitPrice.ToString();
        }
    }
}
