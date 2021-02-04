using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Celestial_Navigation_Calculations
{
    public partial class CelestialNavCalcs : Form
    {
        public CelestialNavCalcs()
        {
            InitializeComponent();
        }

        private void CelestialNavCalcs_Load(object sender, EventArgs e)
        {

        }

        private void bSunCalculation_Click(object sender, EventArgs e)
        {
            new SunCalculation().Show();
            this.Hide();
        }

        

        private void bMeridianAltitude_Click(object sender, EventArgs e)
        {
            new MeridianAltitudeCalculation().Show();
            this.Hide();
        }

        private void button8_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
    }
}
