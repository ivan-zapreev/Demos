namespace EuroConverter
{
    partial class ConverterForm
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
            this.pbEuro = new System.Windows.Forms.PictureBox();
            this.pbToCurr = new System.Windows.Forms.PictureBox();
            this.tbEuroCurr = new System.Windows.Forms.TextBox();
            this.tbOtherCurr = new System.Windows.Forms.TextBox();
            this.btnToEuro = new System.Windows.Forms.Button();
            this.btnToOther = new System.Windows.Forms.Button();
            this.cbCurrType = new System.Windows.Forms.ComboBox();
            this.lbEenEuroIs = new System.Windows.Forms.Label();
            this.tudConvCoeff = new System.Windows.Forms.NumericUpDown();
            this.lbCurrSymb = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.pbEuro)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbToCurr)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.tudConvCoeff)).BeginInit();
            this.SuspendLayout();
            // 
            // pictureBoxLeft
            // 
            this.pbEuro.Image = global::EuroConverter.Properties.Resources.euro;
            this.pbEuro.Location = new System.Drawing.Point(13, 13);
            this.pbEuro.Name = "pictureBoxLeft";
            this.pbEuro.Size = new System.Drawing.Size(100, 99);
            this.pbEuro.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.pbEuro.TabIndex = 0;
            this.pbEuro.TabStop = false;
            // 
            // pbToCurr
            // 
            this.pbToCurr.Image = global::EuroConverter.Properties.Resources.dollar;
            this.pbToCurr.Location = new System.Drawing.Point(441, 13);
            this.pbToCurr.Name = "pbToCurr";
            this.pbToCurr.Size = new System.Drawing.Size(100, 99);
            this.pbToCurr.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.pbToCurr.TabIndex = 1;
            this.pbToCurr.TabStop = false;
            // 
            // tbEuroCurr
            // 
            this.tbEuroCurr.Location = new System.Drawing.Point(120, 28);
            this.tbEuroCurr.Name = "tbEuroCurr";
            this.tbEuroCurr.Size = new System.Drawing.Size(100, 20);
            this.tbEuroCurr.TabIndex = 2;
            this.tbEuroCurr.Text = "1";
            this.tbEuroCurr.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            // 
            // tbOtherCurr
            // 
            this.tbOtherCurr.Location = new System.Drawing.Point(335, 28);
            this.tbOtherCurr.Name = "tbOtherCurr";
            this.tbOtherCurr.Size = new System.Drawing.Size(100, 20);
            this.tbOtherCurr.TabIndex = 3;
            this.tbOtherCurr.Text = "2,00";
            this.tbOtherCurr.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            // 
            // button2
            // 
            this.btnToEuro.Location = new System.Drawing.Point(288, 28);
            this.btnToEuro.Name = "button2";
            this.btnToEuro.Size = new System.Drawing.Size(26, 23);
            this.btnToEuro.TabIndex = 5;
            this.btnToEuro.Text = ">";
            this.btnToEuro.UseVisualStyleBackColor = true;
            this.btnToEuro.Click += new System.EventHandler(this.btnToOther_Click);
            // 
            // button1
            // 
            this.btnToOther.Location = new System.Drawing.Point(240, 28);
            this.btnToOther.Name = "button1";
            this.btnToOther.Size = new System.Drawing.Size(26, 23);
            this.btnToOther.TabIndex = 6;
            this.btnToOther.Text = "<";
            this.btnToOther.UseVisualStyleBackColor = true;
            this.btnToOther.Click += new System.EventHandler(this.btnToEuro_Click);
            // 
            // cbCurrType
            // 
            this.cbCurrType.FormattingEnabled = true;
            this.cbCurrType.Items.AddRange(new object[] {
            "USD",
            "GBP",
            "YEN"});
            this.cbCurrType.Location = new System.Drawing.Point(335, 78);
            this.cbCurrType.Name = "cbCurrType";
            this.cbCurrType.Size = new System.Drawing.Size(100, 21);
            this.cbCurrType.TabIndex = 7;
            this.cbCurrType.SelectedIndexChanged += new System.EventHandler(this.tbEuroCurr_SelectedIndexChanged);
            // 
            // lbEenEuroIs
            // 
            this.lbEenEuroIs.AutoSize = true;
            this.lbEenEuroIs.Location = new System.Drawing.Point(130, 81);
            this.lbEenEuroIs.Name = "lbEenEuroIs";
            this.lbEenEuroIs.Size = new System.Drawing.Size(73, 13);
            this.lbEenEuroIs.TabIndex = 8;
            this.lbEenEuroIs.Text = "Kies 1 Euro = ";
            // 
            // tudConvCoeff
            // 
            this.tudConvCoeff.DecimalPlaces = 2;
            this.tudConvCoeff.Increment = new decimal(new int[] {
            1,
            0,
            0,
            131072});
            this.tudConvCoeff.Location = new System.Drawing.Point(210, 79);
            this.tudConvCoeff.Minimum = new decimal(new int[] {
            1,
            0,
            0,
            131072});
            this.tudConvCoeff.Name = "tudConvCoeff";
            this.tudConvCoeff.Size = new System.Drawing.Size(67, 20);
            this.tudConvCoeff.TabIndex = 9;
            this.tudConvCoeff.Value = new decimal(new int[] {
            20,
            0,
            0,
            65536});
            // 
            // lbCurrSymb
            // 
            this.lbCurrSymb.AutoSize = true;
            this.lbCurrSymb.Font = new System.Drawing.Font("Microsoft Sans Serif", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.lbCurrSymb.Location = new System.Drawing.Point(282, 80);
            this.lbCurrSymb.Name = "lbCurrSymb";
            this.lbCurrSymb.Size = new System.Drawing.Size(16, 18);
            this.lbCurrSymb.TabIndex = 10;
            this.lbCurrSymb.Text = "$";
            // 
            // ConverterForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(553, 131);
            this.Controls.Add(this.lbCurrSymb);
            this.Controls.Add(this.tudConvCoeff);
            this.Controls.Add(this.lbEenEuroIs);
            this.Controls.Add(this.cbCurrType);
            this.Controls.Add(this.btnToOther);
            this.Controls.Add(this.btnToEuro);
            this.Controls.Add(this.tbOtherCurr);
            this.Controls.Add(this.tbEuroCurr);
            this.Controls.Add(this.pbToCurr);
            this.Controls.Add(this.pbEuro);
            this.Name = "ConverterForm";
            this.Text = "Euro Converter";
            ((System.ComponentModel.ISupportInitialize)(this.pbEuro)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbToCurr)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.tudConvCoeff)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.PictureBox pbEuro;
        private System.Windows.Forms.PictureBox pbToCurr;
        private System.Windows.Forms.TextBox tbEuroCurr;
        private System.Windows.Forms.TextBox tbOtherCurr;
        private System.Windows.Forms.Button btnToEuro;
        private System.Windows.Forms.Button btnToOther;
        private System.Windows.Forms.ComboBox cbCurrType;
        private System.Windows.Forms.Label lbEenEuroIs;
        private System.Windows.Forms.NumericUpDown tudConvCoeff;
        private System.Windows.Forms.Label lbCurrSymb;
    }
}

