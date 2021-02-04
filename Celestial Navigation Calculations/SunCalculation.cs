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
    public partial class SunCalculation : Form
    {
        public SunCalculation()
        {
            InitializeComponent();
        }

        private void bMainWindow_Click(object sender, EventArgs e)
        {
            new CelestialNavCalcs().Show();
            this.Hide();
        }


        private void button2_Click(object sender, EventArgs e)
        {
            maskedTextBox2.Text = CelestialTool.CalculateTimeOfSightUTC(maskedTextBox1.Text, numericUpDown1.Text);
            textBox1.Text = CelestialTool.CalculateInterpFactor(maskedTextBox2.Text).ToString("N4");
        }

        private void button1_Click(object sender, EventArgs e)
        {
            //Sun Calculation

           
            sunCalculation();
        }
 
        private void sunCalculation()
        {
            double Z = 0.0;
            double P = 0.0;
            double interpFactor = Double.Parse(textBox1.Text);


            double temp = Double.Parse(numericUpDown2.Text);
            double pressure = Double.Parse(numericUpDown3.Text);
            double h = Double.Parse(textBox2.Text);
            double sd = Double.Parse(textBox10.Text);
            double HS = CelestialTool.ConvertInput(textBox11.Text);
            if (HS == 111111)
            {
                textBox11.Text = "Input?";
            }
            double I = CelestialTool.ConvertInput(textBox3.Text);
            if (I == 111111)
            {
                textBox3.Text = "Input?";
            }
            double GHA0 = CelestialTool.ConvertInput(textBox4.Text);
            if (GHA0 == 111111)  
            {
                textBox4.Text = "Input?";
            }
            double GHA1 = CelestialTool.ConvertInput(textBox5.Text);
            if (GHA1 == 111111)
            {
                textBox5.Text = "Input?";
            }
            double DEC0 = CelestialTool.ConvertInput(textBox6.Text);
            if (DEC0 == 111111)
            {
                textBox6.Text = "Input?";
            }
            double DEC1 = CelestialTool.ConvertInput(textBox7.Text);
            if (DEC1 == 111111)
            {
                textBox7.Text = "Input?";
            }
            double DrLAT = CelestialTool.ConvertInput(textBox8.Text);
            if (DrLAT == 111111)
            {
                textBox8.Text = "Input?";
            }
            double DrLong = CelestialTool.ConvertInput(textBox9.Text);
            if (DrLong == 111111)
            {
                textBox9.Text = "Input?";
            }

            double GHA = GHA0 + (interpFactor * (GHA1 - GHA0));
            if (GHA > 360)
            {
                GHA = GHA - 360;
            }

            Double DEC = DEC0 + (interpFactor * (DEC1 - DEC0));

            Double LHA = GHA + DrLong;
            if (LHA > 360)
            {
                LHA = LHA - 360;
            }
            else if (LHA < 0)
            {
                LHA = LHA + 360;
            }

            Double DECrad = DEC * Math.PI / 180;
            Double S = Math.Sin(DECrad);

            Double LHArad = LHA * Math.PI / 180;
            Double C = Math.Cos(DECrad) * Math.Cos(LHArad);

            Double DrLATrad = DrLAT * Math.PI / 180;

            Double HCrad = Math.Asin((S * Math.Sin(DrLATrad)) + (C * Math.Cos(DrLATrad)));
            Double HC = HCrad / (Math.PI / 180);


            Double X = ((S * Math.Cos(DrLATrad)) - (C * Math.Sin(DrLATrad))) / Math.Cos(HCrad);
            if (X > 1)
            {
                X = 1;
            }
            else if (X < -1)
            {
                X = -1;
            }
            Double Zrad = Math.Acos(X);

            if (LHA > 180)
            {
                Z = Zrad / (Math.PI / 180);
            }
            else
            {
                Z = 360 - (Zrad / (Math.PI / 180));
            }
            Z = Math.Round(Z);

            Double D = 0.0293 * Math.Sqrt(h);
            Double H = HS + I - D;
            Double Hrad = H * Math.PI / 180;

            Double SD = sd / 60;

            Double Hcalc = (H + (7.32 / (H + 4.32))) * Math.PI / 180;
            Double f = (0.28 * pressure) / (temp + 273);
            Double refractionConstant = 0.0167 * Math.PI / 180;
            Double Rrad = refractionConstant / Math.Tan(Hcalc);
            Double Ro = Rrad / (Math.PI / 180);
            Double R = f * Ro;

            Double HP = 0.0024;
            Double HPrad = HP * Math.PI / 180;
            Double PArad = HPrad * Math.Cos(Hrad);
            Double PA = PArad / (Math.PI / 180);

            Double HO = H - R + PA + SD;

            P = (HO - HC) * 60;

            textBox12.Text = CelestialTool.PlotAzimuthAndIntercept(Z, P);

        }

        private void SunCalculation_Load(object sender, EventArgs e)
        {

        }
    } 
    
}
