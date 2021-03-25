using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab11
{
    class Supplier
    {
        private int id;
        private string companyName;
        private string city;
        private string homePage;


        public Supplier(int ID, string CompanyName, string City, string HomePage)
        {
            id = ID;
            companyName = CompanyName;
            city = City;
            homePage = HomePage;
        }

        public int Id { get => id;  }
        public string CompanyName { get => companyName; set => companyName = value; }
        public string City { get => city; set => city = value; }
        public string HomePage { get => homePage; set => homePage = value; }

        public override string ToString()
        {
            return "id: " + id + " companyName: " + companyName + " city: " + city+ " homePage: "+ homePage;
        }
    }
}
