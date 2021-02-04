namespace Celestial_Navigation_Calculations
{
    partial class CelestialNavCalcs
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.bSunCalculation = new System.Windows.Forms.Button();
            this.button2 = new System.Windows.Forms.Button();
            this.button3 = new System.Windows.Forms.Button();
            this.button4 = new System.Windows.Forms.Button();
            this.bMeridianAltitude = new System.Windows.Forms.Button();
            this.button6 = new System.Windows.Forms.Button();
            this.button7 = new System.Windows.Forms.Button();
            this.button8 = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // bSunCalculation
            // 
            this.bSunCalculation.Location = new System.Drawing.Point(276, 12);
            this.bSunCalculation.Name = "bSunCalculation";
            this.bSunCalculation.Size = new System.Drawing.Size(247, 48);
            this.bSunCalculation.TabIndex = 0;
            this.bSunCalculation.Text = "Sun Calculation";
            this.bSunCalculation.UseVisualStyleBackColor = true;
            this.bSunCalculation.Click += new System.EventHandler(this.bSunCalculation_Click);
            // 
            // button2
            // 
            this.button2.Location = new System.Drawing.Point(276, 65);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(247, 48);
            this.button2.TabIndex = 1;
            this.button2.Text = "button2";
            this.button2.UseVisualStyleBackColor = true;
            // 
            // button3
            // 
            this.button3.Location = new System.Drawing.Point(276, 118);
            this.button3.Name = "button3";
            this.button3.Size = new System.Drawing.Size(247, 48);
            this.button3.TabIndex = 2;
            this.button3.Text = "button3";
            this.button3.UseVisualStyleBackColor = true;
            // 
            // button4
            // 
            this.button4.Location = new System.Drawing.Point(276, 171);
            this.button4.Name = "button4";
            this.button4.Size = new System.Drawing.Size(247, 48);
            this.button4.TabIndex = 3;
            this.button4.Text = "button4";
            this.button4.UseVisualStyleBackColor = true;
            // 
            // bMeridianAltitude
            // 
            this.bMeridianAltitude.Location = new System.Drawing.Point(276, 224);
            this.bMeridianAltitude.Name = "bMeridianAltitude";
            this.bMeridianAltitude.Size = new System.Drawing.Size(247, 48);
            this.bMeridianAltitude.TabIndex = 4;
            this.bMeridianAltitude.Text = "Meridian Altitude";
            this.bMeridianAltitude.UseVisualStyleBackColor = true;
            this.bMeridianAltitude.Click += new System.EventHandler(this.bMeridianAltitude_Click);
            // 
            // button6
            // 
            this.button6.Location = new System.Drawing.Point(276, 277);
            this.button6.Name = "button6";
            this.button6.Size = new System.Drawing.Size(247, 48);
            this.button6.TabIndex = 5;
            this.button6.Text = "button6";
            this.button6.UseVisualStyleBackColor = true;
            // 
            // button7
            // 
            this.button7.Location = new System.Drawing.Point(276, 330);
            this.button7.Name = "button7";
            this.button7.Size = new System.Drawing.Size(247, 48);
            this.button7.TabIndex = 6;
            this.button7.Text = "button7";
            this.button7.UseVisualStyleBackColor = true;
            // 
            // button8
            // 
            this.button8.Location = new System.Drawing.Point(276, 383);
            this.button8.Name = "button8";
            this.button8.Size = new System.Drawing.Size(247, 48);
            this.button8.TabIndex = 7;
            this.button8.Text = "Exit";
            this.button8.UseVisualStyleBackColor = true;
            this.button8.Click += new System.EventHandler(this.button8_Click);
            // 
            // CelestialNavCalcs
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(786, 584);
            this.Controls.Add(this.button8);
            this.Controls.Add(this.button7);
            this.Controls.Add(this.button6);
            this.Controls.Add(this.bMeridianAltitude);
            this.Controls.Add(this.button4);
            this.Controls.Add(this.button3);
            this.Controls.Add(this.button2);
            this.Controls.Add(this.bSunCalculation);
            this.Name = "CelestialNavCalcs";
            this.Text = "Celestial Navigation Calculations";
            this.Load += new System.EventHandler(this.CelestialNavCalcs_Load);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button bSunCalculation;
        private System.Windows.Forms.Button button2;
        private System.Windows.Forms.Button button3;
        private System.Windows.Forms.Button button4;
        private System.Windows.Forms.Button bMeridianAltitude;
        private System.Windows.Forms.Button button6;
        private System.Windows.Forms.Button button7;
        private System.Windows.Forms.Button button8;
    }
}

