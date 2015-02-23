using System.Windows.Forms;
namespace MijnEigenBrowser
{
    partial class BrowserForm
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
            this.tableLayoutPanel1 = new System.Windows.Forms.TableLayoutPanel();
            this.panel1 = new System.Windows.Forms.Panel();
            this.myBrowser = new System.Windows.Forms.WebBrowser();
            this.tbURL = new System.Windows.Forms.TextBox();
            this.lblDocsNav = new System.Windows.Forms.Label();
            this.btnGO = new System.Windows.Forms.Button();
            this.rpbBrowser = new System.Windows.Forms.ProgressBar();
            this.tableLayoutPanel1.SuspendLayout();
            this.panel1.SuspendLayout();
            this.SuspendLayout();
            // 
            // tableLayoutPanel1
            // 
            this.tableLayoutPanel1.ColumnCount = 1;
            this.tableLayoutPanel1.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 50F));
            this.tableLayoutPanel1.Controls.Add(this.myBrowser, 0, 1);
            this.tableLayoutPanel1.Controls.Add(this.panel1, 0, 0);
            this.tableLayoutPanel1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.tableLayoutPanel1.Location = new System.Drawing.Point(0, 0);
            this.tableLayoutPanel1.Name = "tableLayoutPanel1";
            this.tableLayoutPanel1.RowCount = 2;
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 5.255255F));
            this.tableLayoutPanel1.RowStyles.Add(new System.Windows.Forms.RowStyle(System.Windows.Forms.SizeType.Percent, 94.74474F));
            this.tableLayoutPanel1.Size = new System.Drawing.Size(1066, 666);
            this.tableLayoutPanel1.TabIndex = 0;
            // 
            // panel1
            // 
            this.panel1.Controls.Add(this.tbURL);
            this.panel1.Controls.Add(this.lblDocsNav);
            this.panel1.Controls.Add(this.btnGO);
            this.panel1.Controls.Add(this.rpbBrowser);
            this.panel1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.panel1.Location = new System.Drawing.Point(3, 3);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(1060, 28);
            this.panel1.TabIndex = 0;
            // 
            // myBrowser
            // 
            this.myBrowser.Dock = System.Windows.Forms.DockStyle.Fill;
            this.myBrowser.Location = new System.Drawing.Point(3, 37);
            this.myBrowser.MinimumSize = new System.Drawing.Size(20, 20);
            this.myBrowser.Name = "myBrowser";
            this.myBrowser.Size = new System.Drawing.Size(1060, 626);
            this.myBrowser.TabIndex = 7;
            // 
            // tbURL
            // 
            this.tbURL.Location = new System.Drawing.Point(3, 4);
            this.tbURL.Name = "tbURL";
            this.tbURL.Size = new System.Drawing.Size(522, 20);
            this.tbURL.TabIndex = 10;
            // 
            // lblDocsNav
            // 
            this.lblDocsNav.AutoSize = true;
            this.lblDocsNav.Location = new System.Drawing.Point(633, 7);
            this.lblDocsNav.Name = "lblDocsNav";
            this.lblDocsNav.Size = new System.Drawing.Size(13, 13);
            this.lblDocsNav.TabIndex = 13;
            this.lblDocsNav.Text = "0";
            // 
            // btnGO
            // 
            this.btnGO.Location = new System.Drawing.Point(531, 3);
            this.btnGO.Name = "btnGO";
            this.btnGO.Size = new System.Drawing.Size(48, 20);
            this.btnGO.TabIndex = 11;
            this.btnGO.Text = "GO";
            this.btnGO.UseVisualStyleBackColor = true;
            // 
            // rpbBrowser
            // 
            this.rpbBrowser.Enabled = false;
            this.rpbBrowser.Location = new System.Drawing.Point(585, 3);
            this.rpbBrowser.Name = "rpbBrowser";
            this.rpbBrowser.Size = new System.Drawing.Size(42, 20);
            this.rpbBrowser.TabIndex = 12;
            // 
            // BrowserForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1066, 666);
            this.Controls.Add(this.tableLayoutPanel1);
            this.Name = "BrowserForm";
            this.Text = "Mijn Eigen Browser";
            this.tableLayoutPanel1.ResumeLayout(false);
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private TableLayoutPanel tableLayoutPanel1;
        private WebBrowser myBrowser;
        private Panel panel1;
        private TextBox tbURL;
        private Label lblDocsNav;
        private Button btnGO;
        private ProgressBar rpbBrowser;

    }
}

