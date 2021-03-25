using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab11
{
    class Category
    {
        private int id;
        private string name;
        private string description;

        public Category(int ID, string Name, string Description)
        {
            id = ID;
            name = Name;
            description = Description;
        }

        public int Id { get => id; }
        public string Name { get => name; set => name = value; }
        public string Description { get => description; set => description = value; }

        public override string ToString()
        {
            return "id: " +id+ " name: "+name + " description: "+description;
        }
    }
}
